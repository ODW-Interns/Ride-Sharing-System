package com.odw.ride_sharing_service;

public class CommandController {
    
    CommandController() {
    }
    
    public void create(InputType input) {
        switch (input.getType()) {
        case 1:
            //createCar();
        case 2:
            //createDriver();
        case 3:
            //createPickup();
        default:
            
        break;
        }
    }

    public void modify(InputType input_) {
        switch (input_.getType()) {
        case 1:
            //modifyCar();
        case 2:
            //modifyDriver();
        case 3:
            //modifyPickup();
        default:
            
        break;
        }
        
    }
    
    public void delete(InputType input_) {
        switch (input_.getType()) {
        case 1:
            //deleteCar();
        case 2:
            //deleteDriver();
        case 3:
            //deletePickup();
        default:
            
        break;
        }
        
    }
}
