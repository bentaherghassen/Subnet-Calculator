/**
 * 
 * @author bentaherghassen
 *
 */

public class Calculator {

	// Input IP Address and Subnet Mask
	// IP Address
	
	private int a = 192;
	private int b = 168;
	private int c = 0;
	private int d = 1;

	// Subnet Mask
	
	private int sa = 255;
	private int sb = 255;
	private int sc = 255;
	private int sd = 0;

	private String Message;

	/*******************************************/

	private int na, nb, nc, nd;
	private int fa, fb, fc, fd;
	private int la, lb, lc, ld;
	private int wa, wb, wc, wd;
	private int ba, bb, bc, bd;

	public void init() {
		
		// Calculator Network Address
		
		na = sa & a;
		nb = sb & b;
		nc = sc & c;
		nd = sd & d;

		// Calculator First Address
		
		fa = na;
		fb = nb;
		fc = nc;
		fd = nd + 1;

		// Wildcard Netmask
		
		wa = ~sa & 0xff;
		wb = ~sb & 0xff;
		wc = ~sc & 0xff;
		wd = ~sd & 0xff;

		// Calculator Broadcast Address
		
		ba = a | wa;
		bb = b | wb;
		bc = c | wc;
		bd = d | wd;

		// Calculator Last Address
		
		la = ba;
		lb = bb;
		lc = bc;
		ld = bd - 1;
	}

	// "192.168.0.1"
	
	public void setIP(String ip) {
		String[] oct = new String[5];
		oct = ip.split("\\.");
		a = (int) Math.abs(Double.parseDouble(oct[0]));
		b = (int) Math.abs(Double.parseDouble(oct[1]));
		c = (int) Math.abs(Double.parseDouble(oct[2]));
		d = (int) Math.abs(Double.parseDouble(oct[3]));

	}

	public void setSubnet(String subnet) {
		if (Message != "That isn't a valid subnet!") {
			Message = "Results!";
		}
		String[] oct = subnet.split("\\.");
		sa = (int) Math.abs(Double.parseDouble(oct[0]));
		sb = (int) Math.abs(Double.parseDouble(oct[1]));
		sc = (int) Math.abs(Double.parseDouble(oct[2]));
		sd = (int) Math.abs(Double.parseDouble(oct[3]));

		if (sa < 128 && sa != 0) {
			sa = 0;
			Message = "That isn't a valid subnet!";
		}

		if (sb < 128 && sb != 0) {
			sb = 0;
			Message = "That isn't a valid subnet!";
		} else if (sa < sb) {
			sb = 0;
			Message = "That isn't a valid subnet!";
		}

		if (sc < 128 && sc != 0) {
			sc = 0;
			Message = "That isn't a valid subnet!";
		} else if (sb < sc) {
			sc = 0;
			Message = "That isn't a valid subnet!";
		}

		if (sd < 128 && sd != 0) {
			sd = 0;
			Message = "That isn't a valid subnet!";
		} else if (sc < sd) {
			sd = 0;
			Message = "That isn't a valid subnet!";
		}

	}

	public String getFirstadd() {
		return fa + "." + fb + "." + fc + "." + fd;
	}

	public String getLastadd() {
		return la + "." + lb + "." + lc + "." + ld;
	}

	public int getNumberOfHosts() {
		int hosts;
		hosts = (wa > 0) ? (wa + 1) : 1;
		hosts *= (wb > 0) ? (wb + 1) : 1;
		hosts *= (wc > 0) ? (wc + 1) : 1;
		hosts *= (wd > 0) ? (wd + 1) : 1;
		hosts -= 2;
		return hosts;
	}

	public String getBroadcast() {
		return ba + "." + bb + "." + bc + "." + bd;
	}

	public String getWildcard() {
		return wa + "." + wb + "." + wc + "." + wd;
	}

	public String getSubnet() {
		return sa + "." + sb + "." + sc + "." + sd;
	}

	public String getNetwork() {
		return na + "." + nb + "." + nc + "." + nd;
	}

	public void clearMessage() {
		Message = "";
	}

	public String getMessage() {
		return Message;
	}
}