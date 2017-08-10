package com.smgp.server.sample;

import java.io.IOException;
import com.smgp.bean.Deliver;
import com.smgp.bean.Login;
import com.smgp.bean.Submit;
import com.smgp.protocol.Tlv;
import com.smgp.protocol.TlvId;
import com.smgp.server.Server;
import com.smgp.server.inf.ServerEventInterface;
import com.smgp.server.result.LoginResult;
import com.smgp.server.result.SubmitResult;
import com.smgp.server.sample.config.ServerAccountConfFromFile;
import com.smgp.server.sample.config.ServerAccountConfig;
import com.smgp.server.util.CheckValid;
import com.smgp.server.util.Display;
import com.utils.Key;

public class SampleServer {

	private static ServerAccountConfig accountconfig;
	private static String ServerVersion = "3.0";

	private static class server implements ServerEventInterface {
		private Server serverSimulate;
		private ServerConsole serverConsole;

		public server(int port) {
			this.serverSimulate = new Server(this, port);
			this.serverSimulate.start();
			this.serverConsole = new ServerConsole(this);
			this.serverConsole.start();

		}

		public void SendDeliver(Deliver deliver) {
			this.serverSimulate.SendDeliver(deliver);
		}

		public LoginResult onLogin(Login login) {
			Display.DisplayLogin(login, accountconfig);
			if (accountconfig.getPassword(login.Account) == null) {
				return (new LoginResult(52, "", ServerVersion, ""));
			} else if (Key.checkAuth(login.AuthenticatorClient, login.Account,
					accountconfig.getPassword(login.Account), String
							.valueOf(login.timestamp)) == false) {
				return (new LoginResult(21, "", ServerVersion, ""));
			} else if (!accountconfig.getIpAddress(login.Account).equals(
					login.ipaddress)) {
				return (new LoginResult(20, "", ServerVersion, ""));
			}

			return (new LoginResult(0,
					accountconfig.getPassword(login.Account), ServerVersion,
					accountconfig.getSPNum(login.Account)));
		}

		public SubmitResult onSumit(Submit submit, String account) {
			int checkvalue = 0;
			Display.DisplaySubmit(submit);

			// check SPId valid
			if (accountconfig.getSPId(account) != null) {
				int findTlv = 0;
				Tlv[] otherTlv = submit.getOtherTlvArray();
				for (int i = 0; i < otherTlv.length; i++) {
					if (otherTlv[i].Tag == TlvId.MsgSrc) {
						if (otherTlv[i].Value.equals(accountconfig
								.getSPId(account))) {
							findTlv = 1;
						} else {
							checkvalue = 8200;
						}
					}
				}
				if (findTlv == 0)
					checkvalue = 8200;

			}

			// check SrcTermid valid
			if ((submit.getSrcTermid())
					.indexOf(accountconfig.getSPNum(account)) != 0)
				checkvalue = 46;
			// check Other Valid
			if (checkvalue == 0)
				checkvalue = CheckValid.CheckSubmit(submit);
			System.out.println("SubmitResult:" + checkvalue);
			return new SubmitResult(checkvalue);
		}

		public void ListConnected() {
			Display.DisplayClientList(this.serverSimulate.getClientlist(),
					accountconfig);

		}

		public void Exit() {
			this.serverSimulate.stop();
			this.serverConsole.stop();
			
			
		}

	}

	public static void main(String[] args) {
		try {
			accountconfig = new ServerAccountConfFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		server sv = new server(8890);
	}

}
