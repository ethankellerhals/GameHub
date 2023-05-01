//package com.gamehub.myapplication;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.content.Intent;
//import android.widget.TableLayout;
//import android.widget.TableRow;
//import android.widget.TextView;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Random;
//import java.util.ArrayList;
//import java.util.*;
//import java.util.List;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//public class gameAdapter extends BaseAdapter {
//
//    private List<games> disGame;
//
//    public gameAdapter(List<games> disGame) {
//        this.disGame = disGame;
//    }
//
//    @Override
//    public int getCount() {
//        return disGame.size();
//    }
//
//    @Override
//    public games getItem(int position) {
//        return disGame.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = convertView;
//        if (view == null) {
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
//        }
//
//        gameTableMod dist = dist.get(position);
//        TextView nameTextView = view.findViewById(R.id.nameTextView);
//        TextView ageTextView = view.findViewById(R.id.ageTextView);
//        nameTextView.setText(String.valueOf(dist.getID()));
//        nameTextView.setText(dist.getTitle());
//        nameTextView.setText(dist.getPublisher());
//        ageTextView.setText(String.valueOf(dist.getRating()));
//
//        return view;
//    }
//}
//
//
