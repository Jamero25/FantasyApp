package com.example.usuario.fantasyapp;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Usuario on 28/04/2015.
 */
public class ReadLocalJSON {

    private String json ="";
    private ArrayList<Team> teams = new ArrayList<Team>();
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<DetailsPlayer> detailsPlayers = new ArrayList<>();
    private BufferedReader bufferedReader;
    private StringBuilder builder;

        public ArrayList<Team> getTeam(Context c, int indicator){

            try{
                builder = new StringBuilder();
                if(indicator==0){
                   bufferedReader = new BufferedReader(new InputStreamReader(c.getAssets().open("countrys.json")));
                }else {

                    bufferedReader = new BufferedReader(new InputStreamReader(c.getAssets().open("teams.json")));
                }
                String line ="";
                teams.clear();

                while((line=bufferedReader.readLine()) != null){
                    builder.append(line);

                }

               bufferedReader.close();
                json = builder.toString();

                JSONArray jsonArray = new JSONArray(json);

                for (int index = 0; index < jsonArray.length(); index++) {
                    Team course = new Team();

                    JSONObject jsonObject = jsonArray.getJSONObject(index);
                    course.setId(jsonObject.getInt("id"));
                    course.setNameTeam(jsonObject.getString("name"));
                    course.setUrlImagen(jsonObject.getString("description"));
                    teams.add(course);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
                Toast.makeText(c, "No se pudo obtener los datos", Toast.LENGTH_SHORT).show();

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(c,"No se pudo obtener los datos",Toast.LENGTH_SHORT).show();
            }

            return teams;
        }


    public ArrayList<Player> getPlayer(Context c, String name){
        try{
            builder = new StringBuilder();
            if(name != null){
                String json = name+".json";
                bufferedReader = new BufferedReader(new InputStreamReader(c.getAssets().open(json)));
                String line ="";
                players.clear();
                while((line=bufferedReader.readLine()) != null){
                    builder.append(line);
                }
                bufferedReader.close();
                json = builder.toString();
                JSONArray jsonArray = new JSONArray(json);

                for (int index = 0; index < jsonArray.length(); index++) {
                    Player player = new Player();
                    JSONObject jsonObject = jsonArray.getJSONObject(index);
                    player.setId(jsonObject.getInt("id"));
                    player.setUrlImagen(jsonObject.getString("imagen"));
                    player.setName(jsonObject.getString("name"));
                    player.setTeam(jsonObject.getString("team"));
                    player.setValor(jsonObject.getString("valor"));
                    players.add(player);
                }
            }} catch (IOException ex) {
                ex.printStackTrace();
                Toast.makeText(c, "No se pudo obtener los datos", Toast.LENGTH_SHORT).show();

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(c,"No se pudo obtener los datos",Toast.LENGTH_SHORT).show();
            }

            return players;
        }

    public ArrayList<DetailsPlayer> getInformationPlayer(Context c, String name){
        try{
            builder = new StringBuilder();
            if (name!= null){
                String json = name+".json";
                bufferedReader = new BufferedReader(new InputStreamReader(c.getAssets().open(json)));
                String line ="";
                detailsPlayers.clear();
                while((line=bufferedReader.readLine()) != null){
                    builder.append(line);
                }
                bufferedReader.close();
                json = builder.toString();
                JSONArray jsonArray = new JSONArray(json);
                for (int index= 0; index < jsonArray.length(); index++){
                    DetailsPlayer detailsPlayer = new DetailsPlayer();
                    JSONObject jsonObject = jsonArray.getJSONObject(index);
                    detailsPlayer.setName(jsonObject.getString("name"));
                    detailsPlayer.setUrlImagen(jsonObject.getString("imagen"));
                    detailsPlayer.setDescription(jsonObject.getString("description"));
                    detailsPlayers.add(detailsPlayer);

                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            Toast.makeText(c, "No se pudo obtener los datos", Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(c,"No se pudo obtener los datos",Toast.LENGTH_SHORT).show();
        }

        return detailsPlayers;
    }

}