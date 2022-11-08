(function(){"use strict";var e={1994:function(e,t,n){n.d(t,{Z:function(){return c}});var r=n(6265),a=n.n(r);const i=a().create({timeout:1e4,headers:{"Content-Type":"application/json"},withCredentials:!0,crossDomain:!0});var o=i,s=n(173);a().create({timeout:15e3});const l={login(e,t){var n={username:e,password:t};return o.post(s.Z.baseUrl+s.Z.login,n)},emailVerify(e,t){var n={username:e,email:t};return o.post(s.Z.baseUrl+s.Z.email,n)},register(e,t,n,r,a){var i={email:e,code:t,username:n,nickname:r,password:a};return o.post(s.Z.baseUrl+s.Z.register,i)},resetPassward(e,t,n){var r={email:e,code:t,password:n};return o.post(s.Z.baseUrl+s.Z.resetPassword,r)},getUserData(){return console.log("Getting User data axios"),o.get(s.Z.baseUrl+s.Z.dashboard)},getPageData(e,t){return console.log(s.Z.baseUrl+s.Z.pagination+"/"+e+"/"+t),o.get(s.Z.baseUrl+s.Z.pagination+"/"+e+"/"+t)},accurateSearch(e,t){return o.get(s.Z.baseUrl+s.Z.search+e+"/"+t)},blurrySearch(e){return o.get(s.Z.baseUrl+s.Z.search+e)},getMediInfo(e){return o.get(s.Z.baseUrl+s.Z.getMedicine+e)},getMediNote(e){return o.get(s.Z.baseUrl+s.Z.getNote+e)},addMediNote(e,t){var n={note:t};return o.put(s.Z.baseUrl+s.Z.addNote+e,n)},takeMedicine(e,t){return o.get(s.Z.baseUrl+s.Z.takeMedicine+e+"/"+t)},deleteMedicine(e){return o["delete"](s.Z.baseUrl+s.Z.deleteMedicine+e)},addLocation(e){return console.log(e),o.post(s.Z.baseUrl+s.Z.addLocation,e)},deleteLocation(e){return console.log(e),o["delete"](s.Z.baseUrl+s.Z.delLocation+"/"+e.locationid)},getFDAData(e){return o.get('https://api.fda.gov/drug/label.json?search=openfda.brand_name:"'+e+'"&limit=1',{withCredentials:!1})},uploadImage(e,t){let n=new FormData;return n.append("file",e),o({url:s.Z.baseUrl+s.Z.addMedicine+s.Z.uploadImage,method:"post",data:{image:e},onUploadProgress(e){let n=Math.round(e.loaded/e.total*100);t.value=100==n?80:n},headers:{"Content-Type":"multipart/form-data"}})},addMedicine(e){return o.post(s.Z.baseUrl+s.Z.addMedicine,e)}};var c=l},173:function(e,t){const n={baseUrl:"https://medione.herokuapp.com",login:"/user/login",email:"/mail/send",register:"/user/register",resetPassword:"/user/reset",dashboard:"/dashboard",pagination:"/medicine/page",search:"/medicine/search/",getMedicine:"/medicine/detail/",getNote:"/medicine/note/",addNote:"/medicine/note/",takeMedicine:"/medicine/take/",deleteMedicine:"/medicine/",addLocation:"/location",delLocation:"/location",addMedicine:"/medicine",uploadImage:"/uploadImage2",delMedicine:""};t["Z"]=n},8630:function(e,t,n){var r=n(9242),a=n(3396);function i(e,t){const n=(0,a.up)("router-view");return(0,a.wg)(),(0,a.j4)(n)}var o=n(89);const s={},l=(0,o.Z)(s,[["render",i]]);var c=l,d=n(5431);(0,d.z)("/service-worker.js",{ready(){console.log("App is being served from cache by a service worker.\nFor more details, visit https://goo.gl/AFskqB")},registered(){console.log("Service worker has been registered.")},cached(){console.log("Content has been cached for offline use.")},updatefound(){console.log("New content is downloading.")},updated(){console.log("New content is available; please refresh.")},offline(){console.log("No internet connection found. App is running in offline mode.")},error(e){console.error("Error during service worker registration:",e)}});var u=n(6754),m=n(8854),p=n(2748),g={install:e=>{for(const t in p){const n=p[t];e.component(n.name,n)}}};const f=(0,r.ri)(c);f.use(g).use(m.Z).use(u.Z),f.mount("#app")},6754:function(e,t,n){n.d(t,{Z:function(){return G}});var r=n(2483),a=n(4738),i=n(3396),o=n(9242),s=n(7139);const l=e=>((0,i.dD)("data-v-fb68ef46"),e=e(),(0,i.Cn)(),e),c={class:"container"},d={class:"website_header phone_only"},u=l((()=>(0,i._)("h1",{class:"website_title"}," Medicine One ",-1))),m={class:"center_bar content_container",style:{"margin-left":"0"}},p=l((()=>(0,i._)("h3",{class:"desktop_only"},"Medicine One",-1))),g=l((()=>(0,i._)("h4",{class:"desktop_only"},"                                                   by Team 010",-1))),f={class:"center_bar_content"},h=l((()=>(0,i._)("tr",{class:"center_bar_label"},[(0,i._)("label",{class:"center_bar_title"},"User Name")],-1))),b=l((()=>(0,i._)("tr",{class:"center_bar_label"},[(0,i._)("label",{class:"center_bar_title"},"Password")],-1))),_={style:{"text-align":"right"}},v=l((()=>(0,i._)("a",{id:"forget_pwd"},"Forget Password?",-1))),w={class:"warning"},y=l((()=>(0,i._)("div",{class:"purple_button",style:{display:"inline-block"}},[(0,i._)("p",{style:{"margin-top":"0.2em"}},"Register")],-1))),k=l((()=>(0,i._)("div",{class:"purple_button",style:{display:"inline-block"}},[(0,i._)("p",{style:{"margin-top":"0.2em"}},"About Medicine One")],-1)));function Z(e,t,n,r,l,Z){const M=a.Z,N=(0,i.up)("router-link");return(0,i.wg)(),(0,i.iD)("div",c,[(0,i._)("div",d,[(0,i._)("button",{class:"open_button",onClick:t[0]||(t[0]=(...e)=>Z.openSideBar&&Z.openSideBar(...e))}," ☰ "),u]),(0,i.wy)((0,i.Wm)(M,{onCloseSideBarEvent:Z.closeSideBar,ref:"ChildSideBar"},null,8,["onCloseSideBarEvent"]),[[o.F8,l.displayFlag]]),(0,i._)("div",m,[p,g,(0,i._)("table",f,[h,(0,i._)("tr",null,[(0,i.wy)((0,i._)("input",{"onUpdate:modelValue":t[1]||(t[1]=e=>l.userName=e),type:"text",class:"input_area"},null,512),[[o.nr,l.userName,void 0,{trim:!0}]])]),b,(0,i._)("tr",null,[(0,i.wy)((0,i._)("input",{"onUpdate:modelValue":t[2]||(t[2]=e=>l.pwd=e),type:"password",class:"input_area"},null,512),[[o.nr,l.pwd,void 0,{trim:!0}]])]),(0,i._)("tr",_,[(0,i.Wm)(N,{to:"/resetPassword"},{default:(0,i.w5)((()=>[v])),_:1})]),(0,i._)("tr",null,[(0,i._)("p",w,(0,s.zw)(l.warningText),1)]),(0,i._)("tr",null,[(0,i._)("input",{type:"submit",name:"login",value:"Login",class:"purple_button",onClick:t[3]||(t[3]=(...e)=>Z.handleLogin&&Z.handleLogin(...e))})]),(0,i._)("tr",null,[(0,i.Wm)(N,{to:"/register"},{default:(0,i.w5)((()=>[y])),_:1})]),(0,i._)("tr",null,[l.displayDeskOnly?((0,i.wg)(),(0,i.j4)(N,{key:0,to:"/about"},{default:(0,i.w5)((()=>[k])),_:1})):(0,i.kq)("",!0)])])])])}var M=n(4775),N=(n(3163),n(1994)),U={name:"HomeView",data(){return{displayFlag:!1,displayDeskOnly:!0,warningText:"",userName:"",pwd:""}},components:{SideBar:a.Z},methods:{openSideBar(){this.displayFlag=!0},closeSideBar(){this.displayFlag=!1},handleLogin(){this.verifyUser()},verifyUser(){var e=this;console.log(e.userName),console.log(e.pwd.length>0?"password entered":"Password is empty");const t=this.openFullScreen2();N.Z.login(e.userName,e.pwd).then((function(n){console.log(n.data.data),console.log(n),t.close(),200==n.data.status?(e.$store.commit("authenticate"),e.$router.push({path:"/dashboard/"+n.data.data.username})):e.warningText="Incorrect username or password, please try again"})),console.log("Auth flag "+e.$store.getters.isAuthenticated)},openFullScreen2(){const e=M.kN.service({lock:!0,text:"Loading",background:"rgba(0, 0, 0, 0.7)"});return e}},mounted(){this.displayDeskOnly=window.innerWidth>992}},S=n(89);const C=(0,S.Z)(U,[["render",Z],["__scopeId","data-v-fb68ef46"]]);var z=C,F=n.p+"img/Error-404.a2e319fc.png",P=n.p+"img/capsules.f2550c46.png",A=n.p+"img/pills.f10b408a.png";const D={class:"error-container"},L={class:"error-content"},O=(0,i.uE)('<div class="pic-error"><img alt="401" class="pic-error-parent" src="'+F+'"><img alt="401" class="pic-error-child left" src="'+P+'"><img alt="401" class="pic-error-child mid" src="'+A+'"><img alt="401" class="pic-error-child right" src="'+P+'"></div>',1),j={class:"bullshit"},I={class:"bullshit-oops"},E={class:"bullshit-headline"},W={class:"bullshit-info"},x={class:"bullshit-return-home",href:"#/"};function B(e,t,n,r,a,o){return(0,i.wg)(),(0,i.iD)("div",D,[(0,i._)("div",L,[O,(0,i._)("div",j,[(0,i._)("div",I,(0,s.zw)(e.oops),1),(0,i._)("div",E,(0,s.zw)(e.headline),1),(0,i._)("div",W,(0,s.zw)(e.info),1),(0,i._)("a",x,(0,s.zw)(e.jumpTime)+"s "+(0,s.zw)(e.btn),1)])])])}var T=n(4870),V=(n(8854),(0,i.aZ)({name:"Page404",setup(){const e=(0,r.tv)(),t=(0,T.iH)(0),n=(0,T.iH)(10),a=(0,T.iH)("Sorry!"),o=(0,T.iH)("Current Page Not Found..."),s=(0,T.iH)("Please check the URL, or click the button to return to the login page"),l=(0,T.iH)("retrun to login"),c=()=>{let t=null;t=setInterval((()=>{n.value>0?n.value--:(e.push("/"),clearInterval(t))}),1e3)};return(0,i.bv)((()=>{c()})),(0,i.Jd)((()=>{clearInterval(t)})),{jumpTime:n,oops:a,headline:o,info:s,btn:l,timer:t}}}));const q=(0,S.Z)(V,[["render",B]]);var H=q;const $=[{path:"/",name:"home",component:z},{path:"/about",name:"about",component:()=>n.e(443).then(n.bind(n,9004))},{path:"/register",name:"register",component:()=>Promise.all([n.e(785),n.e(685)]).then(n.bind(n,1515))},{path:"/dashboard/:username",name:"dashboard",component:()=>Promise.all([n.e(785),n.e(966)]).then(n.bind(n,9422))},{path:"/resetPassword",name:"resetPassword",component:()=>Promise.all([n.e(785),n.e(58)]).then(n.bind(n,1772))},{path:"/:pathMatch(.*)*",name:"pageNotFound",component:H}],R=(0,r.p7)({history:(0,r.r5)("/"),routes:$});var G=R},8854:function(e,t,n){var r=n(1994),a=n(65);t["Z"]=(0,a.MT)({state:{user:{authenticationFlag:!1,userName:"",nickName:"",userEmail:"",numMedicine:null,locations:null,userMatadata:null},search:{isAccurate:null,result:null},refreshFlag:!1},getters:{isAuthenticated(e){return e.user.authenticationFlag},getLocationMap(e){return e.user.locations},getUserData(e){return e.user.userMatadata},getNumMedi(e){return e.user.numMedicine},getRefreshFlag(e){return e.refreshFlag},getEmail(e){return e.user.userEmail},getLocations(e){return e.user.locations},getUserName(e){return e.user.userName},getAutoCompleteData(e){console.log("Processing auto complete data");for(var t=[],n=0;n<e.user.numMedicine;n++){for(var r=e.user.userMatadata[n].brandname,a=e.user.userMatadata[n].locationid,i="NO Location",o=0;o<e.user.locations.length;o++){var s=e.user.locations[o].address;a==e.user.locations[o].locationid&&(i=s)}t.push({value:r,link:i})}return console.log("Finish precessing data"),console.log(t),t}},mutations:{authenticate(e){console.log("Authentication flag changed"),e.user.authenticationFlag=!0,console.log("Auth flag "+e.user.authenticationFlag)},setRefreshFlag(e,t){console.log("Set refresh flag to "+t),e.refreshFlag=t},userLogOff(e){console.log("Authentication flag changed"),e.user.authenticationFlag=!1,console.log("Auth flag "+e.user.authenticationFlag)},updateUser(e,t){console.log("Updating user info"),e.user.userName=t.username,console.log("user name : "+e.user.userName),e.user.nickName=t.nickname,console.log("nick name : "+e.user.nickName),e.user.userEmail=t.email,console.log("user email: "+e.user.userEmail),e.user.numMedicine=t.simplemsg.length,console.log("num of medicine : "+e.user.numMedicine),console.log("Updating user data"),e.user.locations=t.location,console.log("locations : "+e.user.locations),e.user.userMatadata=t.simplemsg,console.log("metadata : "+e.user.userMatadata)}},actions:{asynUpdateUser({commit:e}){r.Z.getUserData().then((t=>{console.log(t.data),e("updateUser".res.data)}))}},modules:{}})},4738:function(e,t,n){n.d(t,{Z:function(){return z}});var r=n(1015),a=(n(8474),n(3396)),i=n(7139);const o=e=>((0,a.dD)("data-v-421f3bd6"),e=e(),(0,a.Cn)(),e),s={class:"side_bar",id:"side_bar"},l={class:"side_bar_title"},c=o((()=>(0,a._)("h2",{class:"side_bar_medicine_one"}," Medicine One ",-1))),d=o((()=>(0,a._)("div",{class:"side_bar_team_010"}," by Team 010 ",-1))),u={key:0,class:"side_bar_line"},m={style:{"padding-right":"1.2em"}},p=o((()=>(0,a._)("span",{style:{"margin-left":"1em"}}," Dashboard ",-1))),g={class:"user_name"},f={class:"user_nick_name"},h=o((()=>(0,a._)("hr",{class:"side_bar_line",style:{"margin-top":"1em"}},null,-1))),b={class:"side_bar_item"},_=o((()=>(0,a._)("span",{style:{"margin-left":"1em"}},"Log in",-1))),v={class:"side_bar_item side_bar_selected"},w=o((()=>(0,a._)("span",{style:{"margin-left":"1em"}},"About",-1))),y=o((()=>(0,a._)("span",{style:{"margin-left":"1em"}},"Add Medicine",-1))),k=o((()=>(0,a._)("span",{style:{"margin-left":"1em"}},"My Location",-1))),Z=o((()=>(0,a._)("span",{style:{"margin-left":"1em"}},"Log off",-1))),M=o((()=>(0,a._)("span",{style:{"margin-left":"1em"}},"About",-1)));function N(e,t,n,o,N,U){const S=(0,a.up)("CloseBold"),C=r.gn,z=(0,a.up)("House"),F=(0,a.up)("User"),P=(0,a.up)("router-link"),A=(0,a.up)("InfoFilled"),D=(0,a.up)("CirclePlus"),L=(0,a.up)("Location"),O=(0,a.up)("SwitchButton");return(0,a.wg)(),(0,a.iD)("div",s,[(0,a._)("div",l,[(0,a._)("button",{class:"close_button",onClick:t[0]||(t[0]=(...e)=>U.closeBar&&U.closeBar(...e))},[(0,a.Wm)(C,{size:30},{default:(0,a.w5)((()=>[(0,a.Wm)(S)])),_:1})]),c,d]),"complex"==n.displayVersion?((0,a.wg)(),(0,a.iD)("hr",u)):(0,a.kq)("",!0),"complex"==n.displayVersion?((0,a.wg)(),(0,a.iD)("div",{key:1,class:"side_bar_item",onClick:t[1]||(t[1]=e=>U.switchMode("default"))},[(0,a._)("div",m,[(0,a.Wm)(C,{size:N.sidebarIconSize},{default:(0,a.w5)((()=>[(0,a.Wm)(z)])),_:1},8,["size"]),p,(0,a._)("p",g,(0,i.zw)(n.user.nickName),1),(0,a._)("p",f,(0,i.zw)(n.user.userName),1)])])):(0,a.kq)("",!0),h,"simple"==n.displayVersion?((0,a.wg)(),(0,a.j4)(P,{key:2,to:"/"},{default:(0,a.w5)((()=>[(0,a._)("div",b,[(0,a._)("div",null,[(0,a.Wm)(C,{size:N.sidebarIconSize},{default:(0,a.w5)((()=>[(0,a.Wm)(F)])),_:1},8,["size"]),_])])])),_:1})):(0,a.kq)("",!0),"simple"==n.displayVersion?((0,a.wg)(),(0,a.j4)(P,{key:3,to:"/about"},{default:(0,a.w5)((()=>[(0,a._)("div",v,[(0,a._)("div",null,[(0,a.Wm)(C,{size:N.sidebarIconSize},{default:(0,a.w5)((()=>[(0,a.Wm)(A)])),_:1},8,["size"]),w])])])),_:1})):(0,a.kq)("",!0),"complex"==n.displayVersion?((0,a.wg)(),(0,a.iD)("div",{key:4,class:"side_bar_item",onClick:t[2]||(t[2]=e=>U.switchMode("add_medi"))},[(0,a._)("div",null,[(0,a.Wm)(C,{size:N.sidebarIconSize},{default:(0,a.w5)((()=>[(0,a.Wm)(D)])),_:1},8,["size"]),y])])):(0,a.kq)("",!0),"complex"==n.displayVersion?((0,a.wg)(),(0,a.iD)("div",{key:5,class:"side_bar_item",onClick:t[3]||(t[3]=e=>U.switchMode("my_loca"))},[(0,a._)("div",null,[(0,a.Wm)(C,{size:N.sidebarIconSize},{default:(0,a.w5)((()=>[(0,a.Wm)(L)])),_:1},8,["size"]),k])])):(0,a.kq)("",!0),"complex"==n.displayVersion?((0,a.wg)(),(0,a.iD)("div",{key:6,class:"side_bar_item",onClick:t[4]||(t[4]=e=>U.switchMode("log_off"))},[(0,a._)("div",null,[(0,a.Wm)(C,{size:N.sidebarIconSize},{default:(0,a.w5)((()=>[(0,a.Wm)(O)])),_:1},8,["size"]),Z])])):(0,a.kq)("",!0),"complex"==n.displayVersion?((0,a.wg)(),(0,a.iD)("div",{key:7,class:"side_bar_item",onClick:t[5]||(t[5]=e=>U.switchMode("about"))},[(0,a._)("div",null,[(0,a.Wm)(C,{size:N.sidebarIconSize},{default:(0,a.w5)((()=>[(0,a.Wm)(A)])),_:1},8,["size"]),M])])):(0,a.kq)("",!0)])}var U={name:"SideBar",data(){return{sidebarIconSize:30}},props:{displayVersion:{type:String,default:"simple"},user:{type:Object,default:{userName:"User Name",nickName:"User Nick Name"}}},methods:{closeBar(){this.$emit("close-side-bar-event")},switchMode(e){var t={view:e};this.$emit("switch-event",t)}},mounted(){window.innerWidth<992&&(this.sidebarIconSize=20)}},S=n(89);const C=(0,S.Z)(U,[["render",N],["__scopeId","data-v-421f3bd6"]]);var z=C}},t={};function n(r){var a=t[r];if(void 0!==a)return a.exports;var i=t[r]={exports:{}};return e[r].call(i.exports,i,i.exports,n),i.exports}n.m=e,function(){var e=[];n.O=function(t,r,a,i){if(!r){var o=1/0;for(d=0;d<e.length;d++){r=e[d][0],a=e[d][1],i=e[d][2];for(var s=!0,l=0;l<r.length;l++)(!1&i||o>=i)&&Object.keys(n.O).every((function(e){return n.O[e](r[l])}))?r.splice(l--,1):(s=!1,i<o&&(o=i));if(s){e.splice(d--,1);var c=a();void 0!==c&&(t=c)}}return t}i=i||0;for(var d=e.length;d>0&&e[d-1][2]>i;d--)e[d]=e[d-1];e[d]=[r,a,i]}}(),function(){n.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return n.d(t,{a:t}),t}}(),function(){n.d=function(e,t){for(var r in t)n.o(t,r)&&!n.o(e,r)&&Object.defineProperty(e,r,{enumerable:!0,get:t[r]})}}(),function(){n.f={},n.e=function(e){return Promise.all(Object.keys(n.f).reduce((function(t,r){return n.f[r](e,t),t}),[]))}}(),function(){n.u=function(e){return"js/"+({58:"resetPassword",443:"about",685:"register",966:"dashboard"}[e]||e)+"."+{58:"2844bde7",443:"f488568b",685:"21986a9a",785:"51d4333c",966:"f845d056"}[e]+".js"}}(),function(){n.miniCssF=function(e){return"css/"+{58:"resetPassword",443:"about",685:"register",966:"dashboard"}[e]+"."+{58:"6a64f81f",443:"e4374629",685:"c8b04998",966:"a523a97b"}[e]+".css"}}(),function(){n.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"===typeof window)return window}}()}(),function(){n.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)}}(),function(){var e={},t="medicine-one:";n.l=function(r,a,i,o){if(e[r])e[r].push(a);else{var s,l;if(void 0!==i)for(var c=document.getElementsByTagName("script"),d=0;d<c.length;d++){var u=c[d];if(u.getAttribute("src")==r||u.getAttribute("data-webpack")==t+i){s=u;break}}s||(l=!0,s=document.createElement("script"),s.charset="utf-8",s.timeout=120,n.nc&&s.setAttribute("nonce",n.nc),s.setAttribute("data-webpack",t+i),s.src=r),e[r]=[a];var m=function(t,n){s.onerror=s.onload=null,clearTimeout(p);var a=e[r];if(delete e[r],s.parentNode&&s.parentNode.removeChild(s),a&&a.forEach((function(e){return e(n)})),t)return t(n)},p=setTimeout(m.bind(null,void 0,{type:"timeout",target:s}),12e4);s.onerror=m.bind(null,s.onerror),s.onload=m.bind(null,s.onload),l&&document.head.appendChild(s)}}}(),function(){n.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})}}(),function(){n.p="/"}(),function(){var e=function(e,t,n,r){var a=document.createElement("link");a.rel="stylesheet",a.type="text/css";var i=function(i){if(a.onerror=a.onload=null,"load"===i.type)n();else{var o=i&&("load"===i.type?"missing":i.type),s=i&&i.target&&i.target.href||t,l=new Error("Loading CSS chunk "+e+" failed.\n("+s+")");l.code="CSS_CHUNK_LOAD_FAILED",l.type=o,l.request=s,a.parentNode.removeChild(a),r(l)}};return a.onerror=a.onload=i,a.href=t,document.head.appendChild(a),a},t=function(e,t){for(var n=document.getElementsByTagName("link"),r=0;r<n.length;r++){var a=n[r],i=a.getAttribute("data-href")||a.getAttribute("href");if("stylesheet"===a.rel&&(i===e||i===t))return a}var o=document.getElementsByTagName("style");for(r=0;r<o.length;r++){a=o[r],i=a.getAttribute("data-href");if(i===e||i===t)return a}},r=function(r){return new Promise((function(a,i){var o=n.miniCssF(r),s=n.p+o;if(t(o,s))return a();e(r,s,a,i)}))},a={143:0};n.f.miniCss=function(e,t){var n={58:1,443:1,685:1,966:1};a[e]?t.push(a[e]):0!==a[e]&&n[e]&&t.push(a[e]=r(e).then((function(){a[e]=0}),(function(t){throw delete a[e],t})))}}(),function(){var e={143:0};n.f.j=function(t,r){var a=n.o(e,t)?e[t]:void 0;if(0!==a)if(a)r.push(a[2]);else{var i=new Promise((function(n,r){a=e[t]=[n,r]}));r.push(a[2]=i);var o=n.p+n.u(t),s=new Error,l=function(r){if(n.o(e,t)&&(a=e[t],0!==a&&(e[t]=void 0),a)){var i=r&&("load"===r.type?"missing":r.type),o=r&&r.target&&r.target.src;s.message="Loading chunk "+t+" failed.\n("+i+": "+o+")",s.name="ChunkLoadError",s.type=i,s.request=o,a[1](s)}};n.l(o,l,"chunk-"+t,t)}},n.O.j=function(t){return 0===e[t]};var t=function(t,r){var a,i,o=r[0],s=r[1],l=r[2],c=0;if(o.some((function(t){return 0!==e[t]}))){for(a in s)n.o(s,a)&&(n.m[a]=s[a]);if(l)var d=l(n)}for(t&&t(r);c<o.length;c++)i=o[c],n.o(e,i)&&e[i]&&e[i][0](),e[i]=0;return n.O(d)},r=self["webpackChunkmedicine_one"]=self["webpackChunkmedicine_one"]||[];r.forEach(t.bind(null,0)),r.push=t.bind(null,r.push.bind(r))}();var r=n.O(void 0,[998],(function(){return n(8630)}));r=n.O(r)})();
//# sourceMappingURL=app.c91bdc51.js.map