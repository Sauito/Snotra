package com.example.snotra.ui.diary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DiaryViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    public DiaryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is a platupus");
    }
    public LiveData<String> getText() {
        return mText;
    }
}