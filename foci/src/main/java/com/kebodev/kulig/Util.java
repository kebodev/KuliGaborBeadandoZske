/*
Kuli Gábor beadandó feladat
 */

package com.kebodev.kulig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Util {

    public static ArrayList<Matches> retrieveRepositoriesFromResponse(String response) throws
            JSONException {
        if (null == response) {
            return new ArrayList<>();
        }
        JSONArray matches = new JSONObject(response).getJSONArray("fixtures");
        ArrayList<Matches> repositories = new ArrayList<>();
        for (int i = 0; i < matches.length(); i++) {
            JSONObject matchData = matches.getJSONObject(i);
            Matches repository = new Matches();
            repository.setHomeTeam(matchData.getString("homeTeamName"));
            repository.setAwayTeam(matchData.getString("awayTeamName"));
            repository.setDateOfGame(matchData.getString("date").substring(0,10));
            repositories.add(repository);
        }

        return repositories;
    }
}
