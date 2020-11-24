package FunctionFragment.CategoryFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.myproject.R;
import com.example.myproject.databinding.ListCategoryFragmentBinding;

public class ShowListCategoryFragment extends Fragment {

    ListCategoryFragmentBinding listCategoryFragmentBinding;

    public static ShowListCategoryFragment newInstance() {

        Bundle args = new Bundle();

        ShowListCategoryFragment fragment = new ShowListCategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        listCategoryFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.list_category_fragment,container,false);

        return listCategoryFragmentBinding.getRoot();
    }
}
