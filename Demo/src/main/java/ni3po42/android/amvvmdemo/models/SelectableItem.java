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

package ni3po42.android.amvvmdemo.models;

import ni3po42.android.amvvmdemo.R;
import amvvm.implementations.observables.ObservableObject;
import amvvm.implementations.observables.PropertyStore;

public class SelectableItem extends ObservableObject
{
	private PropertyStore store = new PropertyStore();

	private boolean selected;
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected(boolean b)
	{
		if (b != selected)
		{
			selected = b;
			notifyListener("Selected");
		}
	}
	
	public int getImage()
	{
		return R.drawable.ic_launcher;
	}
	
	@Override
	public PropertyStore getPropertyStore()
	{
		return store;
	}

}
