package com.example.smartparking.service.impl;

import com.example.smartparking.model.binding.VehicleAddBindingModel;
import com.example.smartparking.model.entity.*;
import com.example.smartparking.model.enums.UserRoleEnum;
import com.example.smartparking.model.service.VehicleAddServiceModel;
import com.example.smartparking.model.service.VehicleEditServiceModel;
import com.example.smartparking.repository.PictureRepository;
import com.example.smartparking.repository.UserRepository;
import com.example.smartparking.repository.VehicleRepository;
import com.example.smartparking.repository.VehicleTypeRepository;
import com.example.smartparking.service.CloudinaryImage;
import com.example.smartparking.service.CloudinaryService;
import com.example.smartparking.service.VehicleService;
import com.example.smartparking.view.VehicleSummaryView;
import com.example.smartparking.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final VehicleTypeRepository vehicleTypeRepository;
    private final CloudinaryService cloudinaryService;
    private final PictureRepository pictureRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository,
                              ModelMapper modelMapper,
                              UserRepository userRepository,
                              VehicleTypeRepository vehicleTypeRepository,
                              CloudinaryService cloudinaryService, PictureRepository pictureRepository) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.vehicleTypeRepository = vehicleTypeRepository;
        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public VehicleAddServiceModel addVehicle(VehicleAddBindingModel vehicleAddBindingModel, String ownerUsername) throws IOException {
        UserEntity userEntity = userRepository.findByUsername(ownerUsername).orElseThrow();
        VehicleAddServiceModel vehicleAddServiceModel = modelMapper.map(vehicleAddBindingModel, VehicleAddServiceModel.class);
        VehicleEntity newVehicle = modelMapper.map(vehicleAddServiceModel, VehicleEntity.class);
        newVehicle.setOwner(userEntity);

        VehicleTypeEntity vehicleType = vehicleTypeRepository
                .findByVehicleTypeEnum(vehicleAddBindingModel.getVehicleTypeEnum()).orElseThrow();
        newVehicle.setVehicleTypeEntity(vehicleType);

        var picture = createPictureEntity(vehicleAddBindingModel.getPicture());
        pictureRepository.save(picture);
        newVehicle.setPictureEntity(picture);

        VehicleEntity savedVehicle = vehicleRepository.save(newVehicle);
        return modelMapper.map(savedVehicle, VehicleAddServiceModel.class);
    }


    private PictureEntity createPictureEntity(MultipartFile file) throws IOException {
        final CloudinaryImage uploaded = this.cloudinaryService.upload(file);

        return new PictureEntity()
                .setPublicId(uploaded.getPublicId())
                .setUrl(uploaded.getUrl());
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public void deletePicture(String publicId) {
        if (!cloudinaryService.delete(publicId)) {
            return;
        }
        pictureRepository.deleteAllByPublicId(publicId);
    }


    @Override
    public boolean isOwner(String username, Long id) {
        Optional<VehicleEntity> vehicleOpt = vehicleRepository.findById(id);
        Optional<UserEntity> caller = userRepository.findByUsername(username);

        if (vehicleOpt.isEmpty() || caller.isEmpty()) {
            return false;
        } else {
            VehicleEntity vehicleEntity = vehicleOpt.get();
            return isAdmin(caller.get()) || vehicleEntity.getOwner().getUsername().equals(username);
        }
    }


    @Override
    public boolean isAdmin(UserEntity user) {
        return user.
                getRoles().
                stream().
                map(UserRoleEntity::getRole).
                anyMatch(r -> r == UserRoleEnum.ADMIN);
    }

    @Override
    public List<VehicleSummaryView> getAllVehicles() {
        return vehicleRepository.
                findAll().
                stream().
                map(this::map).
                collect(Collectors.toList());
    }

    @Override
    public List<VehicleSummaryView> getAllOwnVehicles(String username) {
        Optional<UserEntity> caller = userRepository.findByUsername(username);
        if (caller.isEmpty()) {
            return null;
        } else if (isAdmin(caller.get())) {
            return getAllVehicles();
        } else {
            return vehicleRepository
                    .findVehicleEntityByOwnerUsername(username)
                    .stream().
                    map(this::map).
                    collect(Collectors.toList());
        }
    }


    private VehicleSummaryView map(VehicleEntity vehicleEntity) {

        return this.modelMapper
                .map(vehicleEntity, VehicleSummaryView.class);

    }

    @Override
    public void editVehicle(VehicleEditServiceModel vehicleEditServiceModel) throws IOException {
        VehicleEntity vehicleEntity =
                vehicleRepository.findById(vehicleEditServiceModel.getId()).orElseThrow(() ->
                        new ObjectNotFoundException("Vehicle with id " + vehicleEditServiceModel.getId() + " not found!"));
        // тук ползвам собствената имплементация на ObjectNotFoundException,
        // която е в web/exception/ObjectNotFoundException

        vehicleEntity.setRegistrationNumber(vehicleEditServiceModel.getRegistrationNumber())
                .setVehicleTypeEntity(vehicleEditServiceModel.getVehicleTypeEntity())
                .setYear(vehicleEditServiceModel.getYear())
                .setBrand(vehicleEditServiceModel.getBrand());

        var picture = createPictureEntity(vehicleEditServiceModel.getPicture());
        pictureRepository.save(picture);
        vehicleEntity.setPictureEntity(picture);

        vehicleRepository.save(vehicleEntity);
    }

    @Override
    public VehicleSummaryView findById(Long id, String currentUser) {
        VehicleSummaryView vehicleSummaryView = this.vehicleRepository
                .findById(id)
                .map(o -> mapSummaryView(currentUser, o))
                .get();
        return vehicleSummaryView;
    }

    private VehicleSummaryView mapSummaryView(String currentUser, VehicleEntity vehicle) {
        VehicleSummaryView vehicleSummaryView = this.modelMapper.map(vehicle, VehicleSummaryView.class);

        return vehicleSummaryView;
    }


}
