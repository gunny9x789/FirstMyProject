package FunctionFragment.CategoryFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myproject.R;
import com.example.myproject.databinding.CategoryFragmentBinding;

public class CategoryFragment extends Fragment {
    CategoryFragmentBinding categoryFragmentBinding;

    public static CategoryFragment newInstance(){
        Bundle args = new Bundle();
        CategoryFragment categoryFragment = new CategoryFragment();
        categoryFragment.setArguments(args);
        return categoryFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        categoryFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.category_fragment,container,false);
        getFragment(ShowListCategoryFragment.newInstance());

        return categoryFragmentBinding.getRoot();
    }

    public void getFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.show_list_category_fragment, fragment).commit();
    }
}
