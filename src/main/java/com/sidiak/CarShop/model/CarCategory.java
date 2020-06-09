package com.sidiak.CarShop.model;
// Created with enum because CarCategory will never change
public enum CarCategory {
   MICRO("micro"), SEDAN("sedan"), CUV("cuv"), SUV("suv"),
    CABRIOLET("cabriolet"), KOMBI("combi"), MINIVAN("minivan"),
    COUPE("coupe"), PICKUP("pickup"), SUPERCAR("supercar"), VAN("van");

    private String category;

    public String getCategory() {
       return category;

    }

   CarCategory(String category){

        this.category = category;
   }
}
