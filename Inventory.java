import java.util.List;

public class Inventory<T extends Supplies> {

	/* STEP 3 */
	private List<T> list;

	public Inventory(List<T> list) {
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}


	/* STEP 5 */
	public int searchByName(List<T> list, String name) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equalsIgnoreCase(name)) {
				return i;
			}
		}

		return -1;
	}


	/* STEP 7 */
	public T checkQty(List<T> list, String name, int desiredQuantity) {

		int index = searchByName(list, name);

		if (index == -1) {
			return null;
		}

		T item = list.get(index);

		if (item.getQuantity() != desiredQuantity) {
			item.setQuantity(desiredQuantity);
		}

		return item;
	}
}
