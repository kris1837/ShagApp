package kz.sirius.myapplication.adapter;

import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import kz.sirius.myapplication.R;

public class SensorsAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LinkedList<String> sensors = new LinkedList<>();

    public void setContent(LinkedList<String> sensors) {
        this.sensors = sensors;
        notifyDataSetChanged();
    }

    public void addContent(String content) {
        sensors.addFirst(content);
        notifyItemInserted(0);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SensorsAdapter.SensorsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_sensors, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SensorsViewHolder) {
            ((SensorsViewHolder) holder).uiTextView.setText(sensors.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return sensors.size();
    }

    public static class SensorsViewHolder extends RecyclerView.ViewHolder {

        TextView uiTextView;

        public SensorsViewHolder(View view) {
            super(view);
            uiTextView = view.findViewById(R.id.uiTextView);
        }
    }
}
