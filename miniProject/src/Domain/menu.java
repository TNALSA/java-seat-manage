package Domain;

import java.sql.Blob;

public class menu {
	private String menuId;
	private String menuName;
	private int menuPrice;
	private String menuCategory;
	private boolean menuIsout;
	private Blob menuImage;
	
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuCategory() {
		return menuCategory;
	}
	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}
	public boolean isMenuIsout() {
		return menuIsout;
	}
	public void setMenuIsout(boolean menuIsout) {
		this.menuIsout = menuIsout;
	}
	public Blob getMenuImage() {
		return menuImage;
	}
	public void setMenuImage(Blob menuImage) {
		this.menuImage = menuImage;
	}
	
	
	
}
