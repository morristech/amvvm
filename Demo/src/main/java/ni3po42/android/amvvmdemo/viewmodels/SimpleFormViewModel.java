/* Copyright 2013 Tim Stratton

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package ni3po42.android.amvvmdemo.viewmodels;

import java.util.ArrayList;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import amvvm.implementations.observables.SimpleCommand;
import amvvm.interfaces.ICommand;
import ni3po42.android.amvvmdemo.R;
import amvvm.implementations.observables.Command;
import amvvm.implementations.observables.ObservableList;
import amvvm.viewmodels.ViewModel;
import ni3po42.android.amvvmdemo.models.UserInfo;
import ni3po42.android.amvvmdemo.models.UserInfo.Gender;

public class SimpleFormViewModel extends ViewModel
{
	private static String prefName = "ni3po42.android.amvvmdemo.userinfo";
	
	public final ObservableList<Gender> Genders = 
			new ObservableList<Gender>(new ArrayList<Gender>());
	
	public SimpleFormViewModel()
	{
		Genders.clear();
		Genders.add(Gender.getMale());
		Genders.add(Gender.getFemale());
	}
	
	public final UserInfo CurrentUserInfo = new UserInfo();
	
	public final SimpleCommand Save = new SimpleCommand()
	{
        @Override
        protected void onExecuted(CommandArgument commandArgument)
        {
            SharedPreferences preference = getActivity().getSharedPreferences(prefName, Context.MODE_PRIVATE);
            CurrentUserInfo.storeInPreference(preference);
            getActivity().getFragmentManager().popBackStackImmediate();
        }
    };
	
	public final SimpleCommand Cancel = new SimpleCommand()
	{
        @Override
        protected void onExecuted(CommandArgument commandArgument)
        {
            getActivity().getFragmentManager().popBackStackImmediate();
        }
    };
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{	
		super.onCreate(savedInstanceState);
		
		SharedPreferences preference = getActivity().getSharedPreferences(prefName, Context.MODE_PRIVATE);
		CurrentUserInfo.retrieveUserInfo(preference);	
		
		setContentView(R.layout.userinfo);
	}
	
}
