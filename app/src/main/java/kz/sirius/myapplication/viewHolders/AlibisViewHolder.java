package kz.sirius.myapplication.viewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kz.sirius.myapplication.R;
import kz.sirius.myapplication.entity.AlibisEntity;

public class AlibisViewHolder extends RecyclerView.ViewHolder {

    TextView city;
    TextView degrees;
    TextView windSpeed;
    Button resetButton;

    public AlibisViewHolder(@NonNull View itemView) {
        super(itemView);

        city = itemView.findViewById(R.id.cityTextView);
        degrees = itemView.findViewById(R.id.degreesTextView);
        windSpeed = itemView.findViewById(R.id.windSpeedTextView);
        resetButton = itemView.findViewById(R.id.resetButton);
    }

    public void bind(AlibisEntity entity) {
        city.setText(entity.getCity());
        degrees.setText(entity.getDegrees());
        windSpeed.setText(entity.getWindSpeed());
    }
}
