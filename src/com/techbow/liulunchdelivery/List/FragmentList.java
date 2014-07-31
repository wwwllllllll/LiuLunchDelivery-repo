package com.techbow.liulunchdelivery.List;

import java.util.ArrayList;
import java.util.List;

import com.techbow.liulunchdelivery.R;
import com.techbow.liulunchdelivery.parameter.DistributionSite;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FragmentList extends Fragment {
	private List<DistributionSite> distributionSiteList;
	private ListView distributionListView;
	private DistributionListViewAdapter distributionListViewAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		distributionSiteList = new ArrayList<DistributionSite>();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_list, container, false);
		distributionListView = (ListView) rootView.findViewById(R.id.distributionList);
		distributionListViewAdapter = new DistributionListViewAdapter(distributionSiteList, getActivity());
		distributionListView.setAdapter(distributionListViewAdapter);
		distributionListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				DistributionSite site = (DistributionSite) distributionListView.getItemAtPosition(position);
				Toast.makeText(getActivity(), "site " + position + " is chosen", Toast.LENGTH_SHORT).show();
			}
		});
		new DistributionListAsyncTask(distributionSiteList, distributionListViewAdapter, getActivity()).execute();
		return rootView;
	}

}
