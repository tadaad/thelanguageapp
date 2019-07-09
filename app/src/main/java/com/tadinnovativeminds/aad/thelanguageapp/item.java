package com.tadinnovativeminds.aad.thelanguageapp;

public class item {

    int background;
    String profileName;
    int profilePhoto;
    int nbFollower;

    public item() {


    }

    public item(int background, String profileName, int profilePhoto, int nbFollower) {
        this.background = background;
        this.profileName = profileName;
        this.profilePhoto = profilePhoto;
        this.nbFollower = nbFollower;


    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(int profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public int getNbFollower() {
        return nbFollower;
    }

    public void setNbFollower(int nbFollower) {
        this.nbFollower = nbFollower;
    }
}
