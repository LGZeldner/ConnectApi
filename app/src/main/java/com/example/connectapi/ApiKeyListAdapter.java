package com.example.connectapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
/* адаптер для вывода объектов в RecyclerView */
public class ApiKeyListAdapter extends RecyclerView.Adapter<ApiKeyListAdapter.ViewHolder>{
    Context context;
    private final LayoutInflater inflater;
    private final List<ApiKey> apiKeys;

    ApiKeyListAdapter(Context context, List<ApiKey> apiKeys) {
        this.apiKeys = apiKeys;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ApiKeyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ApiKeyListAdapter.ViewHolder holder, int position) {
        ApiKey apiKey = apiKeys.get(position);
        holder.nameView.setText(apiKey.getName());
        holder.listItemLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, FullItemActivity.class);
            intent.putExtra("name", apiKey.getName());
            intent.putExtra("value", apiKey.getValue());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return apiKeys.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        ConstraintLayout listItemLayout;
        ViewHolder(View view){
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            listItemLayout = itemView.findViewById(R.id.listItemLayout);
        }
    }

}
