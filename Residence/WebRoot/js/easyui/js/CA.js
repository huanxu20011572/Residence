var _is_Select_SignCert_803592850_$="0";
var selectCert = '';

//����û��б�
function getuserlist(){
	try {
		if(_is_Select_SignCert_803592850_$=="1"){
			return  true;
		}
		 var bResults = '';
         bResults = ztb.GetUserList();
         if(!bResults){
        	 alert("������δ�������Կ�ף�");
        	 return false;
         }else{
        	 var result = bResults.split("&&&");
        	 if(result.length == 2){
        		 selectCert = result[0].split("||")[1];
        		 return selectCert;
        	 }else{
        		 alert("��ʹ��һ�ѵ���Կ��");
        		 return false;	 
        	 }
         }
         _is_Select_SignCert_803592850_$="1";
        return true;
    } catch (e) {
    	_is_Select_SignCert_803592850_$="0";
    	try{
    		var errorDesc=ztb.GetAppLastError();
    		if(errorDesc.indexOf("0xa0071002")>-1){
    		//�û�ȡ��ѡ��֤��
    		}else if(errorDesc.indexOf("0xa0071001")>-1){
    			alert("֤�����û�п��õ�֤��,������δ����Կ�ף�");
    		}else{
    			alert(errorDesc);
    		}
    	}catch (e1) {
    		alert("������û��װ�������ǩ���������밲װ�������·�������cab����");
    	}
        return false;
    }
}

//���֤��
function getkeycert(){
	try {
		if(!getuserlist()){
			return false;
        }
        var keyCert = ztb.GetKeyCert(getuserlist());
        return keyCert;
		} catch (e) {
			alert(ztb.GetAppLastError());
			clearCert();
			return false;
		}
}

//���ݼ���
function encryptdata(id,cert)
{
	var signmsg ;
	if(document.getElementById(id).value!=""&&document.getElementById(id).value!=null){
		signmsg = ztb.EncryptMessage(document.getElementById(id).value,cert);
		document.getElementById(id).value = signmsg;
	}
}

function encryptdataTV(value,cert)
{
	var signmsg ;
	if(value!=""&&value!=null){
		signmsg = ztb.EncryptMessage(value,cert);
		return    signmsg;
	}else{
		return "";
	}
}

//�ļ�����
function encryptfile(localUrl,codeUrl,serverCert){
	var signmsg ;
	signmsg = ztb.EncryptBiddingFile(localUrl,codeUrl,serverCert);	
	return signmsg;
}

function clearCert() {
	try {
		_is_Select_SignCert_803592850_$="0";
        //var b=CryptoAgent.CFCA_ClearUseCerts(true);
        return b;
    } catch (e) {
    	_is_Select_SignCert_803592850_$="0";
    	try{
    		alert(CryptoAgent.CFCA_GetLastErrorDesc());
    	} catch (e1) {
    	}
        return false;
    }
}