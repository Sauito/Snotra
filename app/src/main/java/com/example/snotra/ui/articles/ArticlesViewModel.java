package com.example.snotra.ui.articles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArticlesViewModel extends  ViewModel {
    private final MutableLiveData<String> mText;

    public ArticlesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("text text");
    }

    public LiveData<String> getText(){
        return mText;
    }
}