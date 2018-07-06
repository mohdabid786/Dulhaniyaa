package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.SerializedName;

public class FavouriteResponse {

        @SerializedName("status")
        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
}