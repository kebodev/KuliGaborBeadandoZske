/*
Kuli Gábor beadandó feladat
 */

package com.kebodev.kulig;


import android.os.Parcel;
import android.os.Parcelable;

public class Matches implements Parcelable {

  private String homeTeam;
  private String awayTeam;
  private String dateOfGame;

  public Matches() {

  }

  public Matches(String homeTeam, String awayTeam) {
    setHomeTeam(homeTeam);
    setAwayTeam(awayTeam);
  }

  public Matches(Parcel in) {
    String[] data = new String[in.dataSize()];
    in.readStringArray(data);
    this.homeTeam = data[0];
    this.awayTeam = data[1];
    this.dateOfGame = data[2];

  }

  public static final Creator<Matches> CREATOR = new Creator<Matches>() {
    @Override
    public Matches createFromParcel(Parcel in) {
      return new Matches(in);
    }

    @Override
    public Matches[] newArray(int size) {
      return new Matches[size];
    }
  };

  public String getHomeTeam() {
    return homeTeam;
  }

  public void setHomeTeam(String homeTeam) {
    this.homeTeam = homeTeam;
  }

  public String getAwayTeam() {
    return awayTeam;
  }

  public void setAwayTeam(String awayTeam) {
    this.awayTeam = awayTeam;
  }

  public String getDateOfGame() { return dateOfGame; }

  public void setDateOfGame(String dateOfGame) { this.dateOfGame = dateOfGame; }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeStringArray(new String[]{this.homeTeam, this.awayTeam , this.dateOfGame});
  }



}

