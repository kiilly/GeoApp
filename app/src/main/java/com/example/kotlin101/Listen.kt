import androidx.fragment.app.Fragment;
public class DF_Fragment extends Fragment {
private MyListener listener;
public interface MyListener {
 public void ItemSelected(String link);
  }
 @Override
  public void onAttach(Context context) {
      super.onAttach(context);
      if (context instanceof MyListener) {
        listener = (MyListener) context;
      } 
else 
throw new ClassCastException(context.toString()+"implement DF_Fragment.MyListener");
  }
 public void onSomeClick(View v) {
     listener.ItemSelected("some link");
      }
}