package com.thedevs.mrkai.dyuksha18;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.thedevs.mrkai.dyuksha18.Models.MessageModel;

import java.util.ArrayList;
import java.util.List;

import ai.api.AIDataService;
import ai.api.AIListener;
import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;
import at.markushi.ui.CircleButton;

public class Chat_asist_platorm extends Fragment implements AIListener {


    public EditText sendmsg;
    public CircleButton send_button;
    RecyclerView recyclerView;
    AIService aiService;

    List<MessageModel> msg_info;
    ChatAdapter messagingAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_chat_asist_platorm, container, false);
        final AIConfiguration config = new AIConfiguration("1bf6c5eeb0884582a50b4f347b30ab7c",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);
        aiService = AIService.getService(getActivity(), config);
        aiService.setListener(this);
        final AIDataService aiDataService = new AIDataService(config);
        final AIRequest aiRequest = new AIRequest();

        sendmsg = view.findViewById(R.id.editText);
        send_button = view.findViewById(R.id.button);
        recyclerView = view.findViewById(R.id.recyclerView);

        msg_info = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        msg_info.add(new MessageModel("MSG_TYPE_RECEIVED", "Hey I am Dyuksha'18"));
        messagingAdapter = new ChatAdapter(msg_info, getActivity());
        recyclerView.setAdapter(messagingAdapter);

        send_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onClick(View view) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                messagingAdapter = new ChatAdapter(msg_info, getActivity());
                msg_info.add(new MessageModel("MSG_TYPE_SENT", sendmsg.getText().toString()));
                int newMsgPosition = msg_info.size() - 1;
                messagingAdapter.notifyItemInserted(newMsgPosition);
                recyclerView.scrollToPosition(newMsgPosition);
                aiRequest.setQuery(sendmsg.getText().toString());
                new AsyncTask<AIRequest, Void, AIResponse>() {

                    @Override
                    protected AIResponse doInBackground(AIRequest... aiRequests) {
                        try {
                            final AIResponse response = aiDataService.request(aiRequest);
                            return response;
                        } catch (AIServiceException e) {
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(AIResponse response) {
                        if (response != null) {
                            Result result = response.getResult();
                            if (result.getFulfillment().getSpeech().equals("")) {
                                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                                messagingAdapter = new ChatAdapter(msg_info, getActivity());
                                msg_info.add(new MessageModel("MSG_TYPE_RECEIVED", "Sorry I don't understand"));
                                int newMsgPosition = msg_info.size() - 1;
                                messagingAdapter.notifyItemInserted(newMsgPosition);
                                recyclerView.scrollToPosition(newMsgPosition);
                            } else {
                                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                                messagingAdapter = new ChatAdapter(msg_info, getActivity());
                                msg_info.add(new MessageModel("MSG_TYPE_RECEIVED", result.getFulfillment().getSpeech()));
                                int newMsgPosition = msg_info.size() - 1;
                                messagingAdapter.notifyItemInserted(newMsgPosition);
                                recyclerView.scrollToPosition(newMsgPosition);
                            }
                            sendmsg.setText("");
                        }
                    }
                }.execute(aiRequest);
            }
        });

        return view;
    }




    @Override
    public void onResult(AIResponse result) {

    }

    @Override
    public void onError(AIError error) {

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
