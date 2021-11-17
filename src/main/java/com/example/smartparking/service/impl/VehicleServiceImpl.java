package com.example.smartparking.service.impl;

import com.example.smartparking.model.binding.VehicleAddBindingModel;
import com.example.smartparking.model.entity.*;
import com.example.smartparking.model.enums.UserRoleEnum;
import com.example.smartparking.model.service.VehicleAddServiceModel;
import com.example.smartparking.repository.PictureRepository;
import com.example.smartparking.repository.UserRepository;
import com.example.smartparking.repository.VehicleRepository;
import com.example.smartparking.repository.VehicleTypeRepository;
import com.example.smartparking.service.CloudinaryImage;
import com.example.smartparking.service.CloudinaryService;
import com.example.smartparking.service.VehicleService;
import com.example.smartparking.view.VehicleSummaryView;
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
    public VehicleAddServiceModel addVehicle(VehicleAddBindingModel vehicleAddBindingModel, String ownerId) throws IOException {
        UserEntity userEntity = userRepository.findByUsername(ownerId).orElseThrow();
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
    public boolean isOwner(String userName, Long id) {
        Optional<VehicleEntity> vehicleOpt = vehicleRepository.findById(id);
        Optional<UserEntity> caller = userRepository.findByUsername(userName);

        if (vehicleOpt.isEmpty() || caller.isEmpty()) {
            return false;
        } else {
            VehicleEntity vehicleEntity = vehicleOpt.get();
            return isAdmin(caller.get()) || vehicleEntity.getOwner().getUsername().equals(userName);
        }
    }


    private boolean isAdmin(UserEntity user) {
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

    private VehicleSummaryView map(VehicleEntity vehicleEntity) {
        VehicleSummaryView summaryView = this.modelMapper
                .map(vehicleEntity, VehicleSummaryView.class);

//        summaryView.setModel(offerEntity.getModel().getName());
//        summaryView.setBrand(offerEntity.getModel().getBrand().getName());

        return summaryView;
    }

}
