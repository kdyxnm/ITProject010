if(!self.define){let s,e={};const r=(r,i)=>(r=new URL(r+".js",i).href,e[r]||new Promise((e=>{if("document"in self){const s=document.createElement("script");s.src=r,s.onload=e,document.head.appendChild(s)}else s=r,importScripts(r),e()})).then((()=>{let s=e[r];if(!s)throw new Error(`Module ${r} didn’t register its module`);return s})));self.define=(i,n)=>{const l=s||("document"in self?document.currentScript.src:"")||location.href;if(e[l])return;let o={};const u=s=>r(s,l),c={module:{uri:l},exports:o,require:u};e[l]=Promise.all(i.map((s=>c[s]||u(s)))).then((s=>(n(...s),o)))}}define(["./workbox-79ffe3e0"],(function(s){"use strict";s.setCacheNameDetails({prefix:"medicine-one"}),self.addEventListener("message",(s=>{s.data&&"SKIP_WAITING"===s.data.type&&self.skipWaiting()})),s.precacheAndRoute([{url:"/css/about.e4374629.css",revision:null},{url:"/css/app.85cdcc12.css",revision:null},{url:"/css/dashboard.f6d9d536.css",revision:null},{url:"/css/register.b81d8364.css",revision:null},{url:"/css/resetPassword.09c98763.css",revision:null},{url:"/img/Error-404.a2e319fc.png",revision:null},{url:"/img/background.17fc1e83.png",revision:null},{url:"/img/capsules.f2550c46.png",revision:null},{url:"/img/phone_background.b5e47b7e.png",revision:null},{url:"/img/pills.f10b408a.png",revision:null},{url:"/index.html",revision:"8e1920dc0aafe751373233db71e813f2"},{url:"/js/516.b149bbd7.js",revision:null},{url:"/js/about.76028ca7.js",revision:null},{url:"/js/app.8f96b6fc.js",revision:null},{url:"/js/chunk-vendors.d9062f67.js",revision:null},{url:"/js/dashboard.eb16743d.js",revision:null},{url:"/js/register.e3c3af2a.js",revision:null},{url:"/js/resetPassword.1dbc9d47.js",revision:null},{url:"/manifest.json",revision:"a483bcd6b3914f895fc00dc01dbff84d"},{url:"/robots.txt",revision:"b6216d61c03e6ce0c9aea6ca7808f7ca"}],{})}));
//# sourceMappingURL=service-worker.js.map
