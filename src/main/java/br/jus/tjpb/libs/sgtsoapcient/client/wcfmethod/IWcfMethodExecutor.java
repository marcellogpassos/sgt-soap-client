package br.jus.tjpb.libs.sgtsoapcient.client.wcfmethod;

import com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile;

public interface IWcfMethodExecutor {

    Object execute(IWcfMethod wcfMethod, String methodName, WS_Profile profile);
}
