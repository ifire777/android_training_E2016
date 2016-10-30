package by.mrkip.apps.epamandroidtraining.imageLoader;

import android.widget.ImageView;

public interface SimpleImageLoader {

	void drawBitmap(final ImageView imageView, final String imageUrl);

	class Impl {

		public static SimpleImageLoader newInstance() {
			return new SimpleImageLoaderImpl();

		}
	}

}
