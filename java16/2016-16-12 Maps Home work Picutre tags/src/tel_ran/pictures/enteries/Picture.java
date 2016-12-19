package tel_ran.pictures.enteries;

import java.util.Arrays;

public class Picture {
	private String url;
	private String [] tags;
	public Picture(String url, String[] tags) {
		super();
		this.url = url;
		this.tags = tags;
	}
	
	public String getUrl() {
		return url;
	}
	public String[] getTags() {
		return tags;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Picture other = (Picture) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Picture [url=" + url + ", tags=" + Arrays.toString(tags) + "]";
	}
	
	
	
	
	

}
