package by.mrkip.apps.epamandroidtraining.dataCasting;

import android.text.format.DateUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.mrkip.apps.epamandroidtraining.model.dayCardRequestModel.UFDate;

/**
 * Created by kip on 22.10.2016.
 */

public class DateCast implements JsonDeserializer<UFDate> {
	public static final int MILISECS_IN_DAY = 86400000;
	public static final String TODAY = "Today";
	public static final String YESTERDAY = "Yesterday";
	public static final String TOMORROW = "Tomorrow";
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat ufDateFormat = new SimpleDateFormat("EEE, dd.MM.yyyy");

	@Override
	public UFDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		UFDate result = new UFDate();
		try {
			result.setDate(simpleDateFormat.parse(json.getAsString()));
			result.setUfDate(getDayString(result.getDate()));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}


		return result;
	}


	private String getDayString(Date date) {

		String s;
		if (DateUtils.isToday(date.getTime()))
			s = TODAY;
		else if (DateUtils.isToday(date.getTime() + MILISECS_IN_DAY))
			s = YESTERDAY;
		else if (DateUtils.isToday(date.getTime() - MILISECS_IN_DAY))
			s = TOMORROW;
		else
			s = ufDateFormat.format(date);
		return s;
	}


}
