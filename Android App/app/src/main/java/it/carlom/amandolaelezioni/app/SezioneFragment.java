package it.carlom.amandolaelezioni.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import it.carlom.amandolaelezioni.app.api.ElezioneApi;
import it.carlom.amandolaelezioni.app.api.Sezione;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class SezioneFragment extends Fragment {

    private static final String ARG_NUMBERSEZIONE = "numberSezione";

    private Integer numberSezione;
    private EditText editLista1, editLista2, editLista3;
    private ElezioneApi elezioneApi;


    public static SezioneFragment newInstance(Integer numberSezione) {
        SezioneFragment fragment = new SezioneFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NUMBERSEZIONE, numberSezione);
        fragment.setArguments(args);
        return fragment;
    }

    public SezioneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            numberSezione = getArguments().getInt(ARG_NUMBERSEZIONE);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sezione, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editLista1 = (EditText) view.findViewById(R.id.editLista1);
        editLista2 = (EditText) view.findViewById(R.id.editLista2);
        editLista3 = (EditText) view.findViewById(R.id.editLista3);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ElezioneApi.API_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        elezioneApi = restAdapter.create(ElezioneApi.class);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // If the drawer is open, show the global app actions in the action bar. See also
        // showGlobalContextActionBar, which controls the top-left area of the action bar.

        inflater.inflate(R.menu.menu_sezione, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_invia) {
            updateSezione();
        }

        return super.onOptionsItemSelected(item);
    }


    private void updateSezione() {

        Sezione sezione = new Sezione(numberSezione);

        sezione.setLista1(Integer.parseInt(editLista1.getText().toString()));
        sezione.setLista2(Integer.parseInt(editLista2.getText().toString()));
        sezione.setLista3(Integer.parseInt(editLista3.getText().toString()));

        elezioneApi.updateSezione(sezione, new Callback<List<Sezione>>() {
            @Override
            public void success(List<Sezione> seziones, Response response) {
                Toast.makeText(getActivity(), "aggiornato", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Toast.makeText(getActivity(), "errore", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
