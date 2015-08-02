package effective.java;

import java.util.EnumSet;
import java.util.Set;

public class R32 {
	public enum Style {
		B, I, U, S
	};

	public void applyStyle(Set<Style> styles) {
		for (Style s : styles) {
			System.out.println(s.name());
		}
	}

	public static void main(String[] args) { 
		R32 r = new R32();
		r.applyStyle(EnumSet.of(Style.B, Style.I));
	}

}
