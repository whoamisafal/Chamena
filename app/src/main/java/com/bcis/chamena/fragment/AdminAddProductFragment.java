package com.bcis.chamena.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bcis.chamena.databinding.AdminAddprdBinding;
import com.bcis.chamena.databinding.AdminHomeLayoutBinding;


public class AdminAddProductFragment extends Fragment {
    //Todo:Change this according to the xml file you have created
    AdminAddprdBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // Todo: Change AdminAddprdBinding to binding ClassName
        binding= AdminAddprdBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
