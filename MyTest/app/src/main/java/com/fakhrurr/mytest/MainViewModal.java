package com.fakhrurr.mytest;

import com.fakhrurr.mytest.modal.CuboidModel;

public class MainViewModal {
    private CuboidModel cuboidModel;

    public MainViewModal(CuboidModel cuboidModel) {
        this.cuboidModel = cuboidModel;
    }

    void save(double w, double l, double h) {
        cuboidModel.save(w, l, h);
    }

    double getCircumference() {
        return cuboidModel.getCircumference();
    }

    double getSurfaceArea() {
        return cuboidModel.getSurfaceArea();
    }

    double getVolume() {
        return cuboidModel.getVolume();
    }

}
