package com.example.dell.platform_doctor.model;

import android.os.Parcel;
import android.util.Log;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

/*
 * Created by JohnnyTan on 2017/9/27.
 */

public class SuggesstionItem implements SearchSuggestion{
    private String title;
    private boolean isHistory = false;
    public SuggesstionItem(String title)
    {
        this.title = title;
    }
    @Override
    //getTitle
    public String getBody() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    //储存数据
    public void writeToParcel(Parcel dest, int flags) {
        Log.d("SuggestionItem", "write to parcel");
        dest.writeString(title);
        dest.writeInt(isHistory ? 1 : 0);
    }
}
