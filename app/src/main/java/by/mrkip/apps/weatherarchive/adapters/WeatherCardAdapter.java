package by.mrkip.apps.weatherarchive.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import by.mrkip.apps.weatherarchive.App;
import by.mrkip.apps.weatherarchive.R;
import by.mrkip.apps.weatherarchive.imageLoader.SimpleImageLoader;
import by.mrkip.apps.weatherarchive.model.WeatherCard;

public class WeatherCardAdapter extends RecyclerView.Adapter<WeatherCardAdapter.ViewHolder> {
	private List<WeatherCard> mDataSet;
	private int mDataSetTypes;
	private SimpleImageLoader simpleImageLoader= App.getSimpleImageLoader();


	public static class ViewHolder extends RecyclerView.ViewHolder {
		public ViewHolder(View v) {
			super(v);
		}
	}

	public class WeatherViewHolder extends ViewHolder implements View.OnClickListener {
		private TextView tvDegree;
		private TextView tvHumisity;
		private TextView tvWindSpeed;
		private TextView tvDate;
		private ImageView ivWeatherImg;

		public WeatherViewHolder(View v) {
			super(v);
			v.setOnClickListener(this);
			tvDegree = (TextView) v.findViewById(R.id.dwc_temperature);
			tvHumisity = (TextView) v.findViewById(R.id.dwc_humisity);
			tvWindSpeed = (TextView) v.findViewById(R.id.dwc_windspeed);
			tvDate = (TextView) v.findViewById(R.id.dwc_todaydate);
			ivWeatherImg= (ImageView) v.findViewById(R.id.dwc_weatherimage);

		}

		@Override
		public void onClick(View v) {
			remove(getAdapterPosition());
		}
	}


	public WeatherCardAdapter(List<WeatherCard> dataSet, int dataSetTypes) {
		if (dataSet != null) {
			mDataSet = dataSet;
		} else {
			mDataSet = new ArrayList<>();
		}
		mDataSetTypes = dataSetTypes;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		View v;
		v = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.view_daycard, viewGroup, false);

		return new WeatherViewHolder(v);
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, final int position) {
		//	if (viewHolder.getItemViewType() == WEATHER) {
		WeatherViewHolder holder = (WeatherViewHolder) viewHolder;

		holder.tvDegree.setText(mDataSet.get(position).getTempC());
		holder.tvHumisity.setText(mDataSet.get(position).getHumidity());
		holder.tvWindSpeed.setText(mDataSet.get(position).getWindSpeed());
		holder.tvDate.setText(mDataSet.get(position).getDate());

		simpleImageLoader.drawBitmap(holder.ivWeatherImg,mDataSet.get(position).getImageURL());

		//	}
	}

	@Override
	public int getItemCount() {
		if (mDataSet != null) {
			return mDataSet.size();
		} else {
			return 0;
		}
	}

	public void remove(int position) {
		if (position > -1 && position < mDataSet.size()) {
			mDataSet.remove(position);
			notifyItemRemoved(position);
			notifyItemRangeChanged(position, mDataSet.size());
		}
	}

	public void addItems(List<WeatherCard> items) {
		mDataSet.addAll(items);
		notifyDataSetChanged();
	}

}
