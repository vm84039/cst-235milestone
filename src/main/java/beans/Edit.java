package beans;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;

@ManagedBean(name = "edit")
@ViewScoped
@Stateless
public class Edit {

	@NotNull()
	private int ID;
	@NotNull()
	private String title;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Edit()
	{
		this.ID=0;
		this.title = "";
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
