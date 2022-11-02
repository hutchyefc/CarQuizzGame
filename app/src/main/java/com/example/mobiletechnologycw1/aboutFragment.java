package com.example.mobiletechnologycw1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class aboutFragment extends Fragment {
    View view;
    String info = "  StudentID: B00749060 \\n\n" +
            "  StudentName: John Hutchman. \\n\n" +
            "  \\n\n" +
            "  \\n\n" +
            "  I confirm that I understand what plagiarism is and have read the University’s policy on\\n\n" +
            "  plagiarism and understand the definition of plagiarism. The work that I have submitted \\n\n" +
            "  is entirely my own. Any work from other authors is duly referenced and acknowledged. \\n\n" +
            "  I understand that I may face sanctions in accordance with the policies and procedures \\n\n" +
            "  of the University";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about, container, false);
        return view;
    }

}
