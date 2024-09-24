import axios from 'axios';
import proxy from "../config/proxy";
import {USER_KEY, TOKEN_NAME} from "../config/global";
const env = import.meta.env.MODE || 'development';
const host = env === 'mock' ? 'https://mock.boxuegu.com/mock/3359' : proxy[env].host;

const sleep = (delay) => new Promise((resolve) => setTimeout(resolve, delay))
let isRefresh = false;
let success = false;
export async function tryRefreshToken(){
  if(isRefresh){
    while (isRefresh){
      await sleep(10)
    }
    return success;
  }
  isRefresh = true;
  // 尝试刷新token
  let resp = await axios.get(host + "/as/accounts/refresh", {withCredentials: true});
  if (resp.status === 200 && resp.data.code === 200) {
    sessionStorage.setItem(TOKEN_NAME, resp.data.data)
    success = true;
  }else{
    sessionStorage.removeItem(TOKEN_NAME);
    success = false;
  }
  isRefresh = false;
  return success;
}
