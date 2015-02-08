package ara.kuet.musta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kuet.musta.R;

public class QiblaDirection extends Fragment {

	public final static String TAG = QiblaDirection.class.getSimpleName();

	public QiblaDirection() {
		// TODO Auto-generated constructor stub
	}

	public static QiblaDirection newInstance() {
		return new QiblaDirection();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_qibla, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		TextView textView = (TextView) view.findViewById(R.id.textView);
		textView.setText("Aatik, It's your turn!");
	}
}
