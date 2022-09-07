package com.testInstivo.demo.utils;

import com.testInstivo.demo.entites.Dispatch;

public class DispatchFactory {
    final String CURITIBA_41 = "81880370";
    final String ANTONINA_41 = "83370000";

    final String RIO_DE_JANEIRO_21_SANTA_CRUZ = "23555240";
    final String RIO_DE_JANEIRO_21_PACIENCIA = "23587545";

    public Dispatch create() {
        var dispatch = new Dispatch();

        dispatch.setWeight(10.0);
        dispatch.setZipCodeOrigin(CURITIBA_41);
        dispatch.setZipCodeDestination(ANTONINA_41);
        dispatch.setRecipientName("anderson");

        return dispatch;
    }

    public Dispatch createWithSameDDD() {
        var dispatch = new Dispatch();

        dispatch.setWeight(100.0);
        dispatch.setZipCodeOrigin(CURITIBA_41);
        dispatch.setZipCodeDestination(ANTONINA_41);
        dispatch.setRecipientName("anderson");

        return dispatch;
    }

    public Dispatch createWithSameLocation() {
        var dispatch = new Dispatch();

        dispatch.setWeight(100.0);
        dispatch.setZipCodeOrigin(RIO_DE_JANEIRO_21_PACIENCIA);
        dispatch.setZipCodeDestination(RIO_DE_JANEIRO_21_SANTA_CRUZ);
        dispatch.setRecipientName("anderson");

        return dispatch;
    }

    public Dispatch createWithDiferentLocation() {
        var dispatch = new Dispatch();

        dispatch.setWeight(100.0);
        dispatch.setZipCodeOrigin(ANTONINA_41);
        dispatch.setZipCodeDestination(RIO_DE_JANEIRO_21_SANTA_CRUZ);
        dispatch.setRecipientName("anderson");

        return dispatch;
    }

    public Dispatch createWithWeightEmpty() {
        var dispatch = new Dispatch();

        dispatch.setZipCodeOrigin(CURITIBA_41);
        dispatch.setZipCodeDestination(ANTONINA_41);
        dispatch.setRecipientName("anderson");

        return dispatch;
    }

    public Dispatch createWithZipCodeOriginEmpty() {
        var dispatch = new Dispatch();

        dispatch.setWeight(10.0);
        dispatch.setZipCodeDestination(ANTONINA_41);
        dispatch.setRecipientName("anderson");

        return dispatch;
    }


    public Dispatch createWithZipCodeDestination() {
        var dispatch = new Dispatch();

        dispatch.setWeight(10.0);
        dispatch.setZipCodeOrigin(CURITIBA_41);
        dispatch.setRecipientName("anderson");

        return dispatch;
    }

    public Dispatch createWithRecipientNameEmpty() {
        var dispatch = new Dispatch();

        dispatch.setWeight(10.0);
        dispatch.setZipCodeOrigin(CURITIBA_41);
        dispatch.setZipCodeDestination(ANTONINA_41);


        return dispatch;
    }

}
