"use strict";(self["webpackChunkmedicine_one"]=self["webpackChunkmedicine_one"]||[]).push([[58],{8992:function(e,t,n){n.d(t,{Z:function(){return p}});var a=n(1015),r=(n(8474),n(3396)),l=n(7139);const s={class:"website_header"},o={class:"website_title"};function i(e,t,n,i,c,d){const u=(0,r.up)("Expand"),p=a.gn,_=(0,r.up)("Back");return(0,r.wg)(),(0,r.iD)("div",s,[n.btnStyle==c.sidebar?((0,r.wg)(),(0,r.iD)("button",{key:0,onClick:t[0]||(t[0]=(...e)=>d.openNav&&d.openNav(...e)),class:"open_button"},[(0,r.Wm)(p,null,{default:(0,r.w5)((()=>[(0,r.Wm)(u)])),_:1})])):(0,r.kq)("",!0),n.btnStyle==c.returnbtn?((0,r.wg)(),(0,r.iD)("button",{key:1,onClick:t[1]||(t[1]=(...e)=>d.backToPrev&&d.backToPrev(...e)),class:"open_button"},[(0,r.Wm)(p,null,{default:(0,r.w5)((()=>[(0,r.Wm)(_)])),_:1})])):(0,r.kq)("",!0),(0,r._)("h1",o,(0,l.zw)(n.header),1)])}var c={name:"HeadBar",props:{header:{type:String,default:"About"},btnStyle:{type:String,default:"SideBar"}},data(){return{sidebar:"SideBar",returnbtn:"Return"}},methods:{openNav(){this.$emit("open-side-bar-event")},backToPrev(){this.$router.back(-1)}}},d=n(89);const u=(0,d.Z)(c,[["render",i],["__scopeId","data-v-5f56006c"]]);var p=u},4142:function(e,t,n){n.r(t),n.d(t,{default:function(){return S}});var a=n(1015),r=(n(8474),n(8992)),l=n(3396),s=n(9242),o=n(7139);const i=e=>((0,l.dD)("data-v-6fc66290"),e=e(),(0,l.Cn)(),e),c={class:"container"},d={class:"center_bar content_container",style:{"margin-left":"0"}},u=i((()=>(0,l._)("h3",{class:"desk_top_only"},"Reset Password",-1))),p={class:"center_bar_content"},_=i((()=>(0,l._)("tr",{class:"center_bar_label"},[(0,l._)("label",{class:"center_bar_title"},"Email:")],-1))),w=i((()=>(0,l._)("tr",{class:"center_bar_label"},[(0,l._)("label",{class:"center_bar_title"},"Verification Code:")],-1))),b=i((()=>(0,l._)("tr",{class:"center_bar_label"},[(0,l._)("label",{class:"center_bar_title"},"Set Password:")],-1))),m={key:0,class:"warning"},y=i((()=>(0,l._)("tr",{class:"center_bar_label"},[(0,l._)("label",{class:"center_bar_title"},"Confirm New Password:")],-1)));function v(e,t,n,i,v,g){const f=r.Z,h=(0,l.up)("Back"),k=a.gn;return(0,l.wg)(),(0,l.iD)("div",c,[(0,l.Wm)(f,{header:e.headerTitle,btnStyle:v.headerStyle,class:"phone_only",onOpenSideBarEvent:e.openSideBar},null,8,["header","btnStyle","onOpenSideBarEvent"]),(0,l._)("div",d,[u,(0,l._)("button",{onClick:t[0]||(t[0]=(...e)=>g.backToPrev&&g.backToPrev(...e)),class:"return_button desktop_only"},[(0,l.Wm)(k,{size:30,color:"#6E78F7"},{default:(0,l.w5)((()=>[(0,l.Wm)(h)])),_:1})]),(0,l._)("table",p,[_,(0,l._)("tr",null,[(0,l._)("p",null,[(0,l.wy)((0,l._)("input",{type:"text","onUpdate:modelValue":t[1]||(t[1]=e=>v.email=e),class:"input_area"},null,512),[[s.nr,v.email,void 0,{trim:!0}]])])]),w,(0,l._)("tr",null,[(0,l._)("p",null,[(0,l.wy)((0,l._)("input",{type:"string","onUpdate:modelValue":t[2]||(t[2]=e=>v.code=e),class:"input_area"},null,512),[[s.nr,v.code,void 0,{trim:!0}]])])]),b,(0,l._)("tr",null,[(0,l._)("p",null,[(0,l.wy)((0,l._)("input",{type:"password","onUpdate:modelValue":t[3]||(t[3]=e=>v.pwd=e),class:"input_area"},null,512),[[s.nr,v.pwd,void 0,{trim:!0}]])]),v.iswarning?((0,l.wg)(),(0,l.iD)("p",m,(0,o.zw)(v.warningText),1)):(0,l.kq)("",!0)]),y,(0,l._)("tr",null,[(0,l._)("p",null,[(0,l.wy)((0,l._)("input",{type:"password","onUpdate:modelValue":t[4]||(t[4]=e=>v.pwdRepeat=e),class:"input_area"},null,512),[[s.nr,v.pwdRepeat,void 0,{trim:!0}]])])]),(0,l._)("tr",null,[(0,l._)("p",null,[(0,l._)("input",{type:"button",class:"purple_button",value:"Send Verify Code",onClick:t[5]||(t[5]=(...e)=>g.verifyButton&&g.verifyButton(...e))})])]),(0,l._)("tr",null,[(0,l._)("p",null,[(0,l._)("input",{type:"submit",value:"Confirm",class:"purple_button",onClick:t[6]||(t[6]=(...e)=>g.confirmButton&&g.confirmButton(...e))})])])])])])}var g=n(6078),f={name:"RegisterView",data(){return{iswarning:!1,errorMessage:"",warningText:"",email:"",code:"",pwd:"",pwdRepeat:"",headerStyle:"Return"}},components:{HeadBar:r.Z},methods:{verifyButton(){this.verifyCode()},verifyCode(){var e=this;console.log(this.code),g.Z.emailVerify(e.userName,e.email).then((function(e){console.log(e.data)}))},backToPrev(){this.$router.back(-1)},confirmButton(){this.isEmpty()},isEmpty(){var e=this;e.email.length<1||e.code.length<1||e.pwd<1||e.pwdRepeat<1?(e.iswarning=!0,e.warningText="You must complete all information!",console.log(e.warningText)):e.pwd!=e.pwdRepeat?(e.iswarning=!0,e.warningText="The two password entries are inconsistent, please enter again"):(e.iswarning=!1,this.registerUser())},resetPassword(){var e=this;g.Z.resetPassward(e.email,e.code,e.pwd).then((function(t){console.log(t.data),console.log(typeof e.code),200==t.data.status?e.$router.push({path:"/"}):(e.errorMessage=t.data.msg,alert(e.errorMessage+", please try again!"))}))}},mounted(){this.displayDeskOnly=window.innerWidth>992}},h=n(89);const k=(0,h.Z)(f,[["render",v],["__scopeId","data-v-6fc66290"]]);var S=k}}]);
//# sourceMappingURL=resetPassword.d9e5dfe0.js.map