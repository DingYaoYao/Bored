// 禁止浏览器鼠标右键功能
document.oncontextmenu = function () {
  return false;
}
// 创建一个录音对象
var recorder = new MP3Recorder({
  funCancel: function (msg) {
    console.log(msg);
    recorder = null;
  }
});
var mp3Blob,
  oBtn = document.querySelector('input[type="button"]'),
  oHideTips = document.querySelector('.hide-tips-wrap'),
  oMarkIcon = oHideTips.querySelector('.tips-icon'),
  oTipsTxt = oHideTips.querySelector('.tips-txt');
oBtn.addEventListener('touchstart', function () {
  recorder.start();
  oHideTips.style.display = 'block';
});
oBtn.addEventListener('touchmove', function (e) {
  e.preventDefault();
});
oBtn.addEventListener('touchend', function () {
  recorder.stop();
  recorder.getMp3Blob(function (blob) {
    mp3Blob = blob;
    var url = URL.createObjectURL(mp3Blob),
      // 获取语言列表容器
      oWrap = document.querySelector('.voice-wrap'),
      // 创建li
      oLi = document.createElement('li'),
      // 创建audio标签
      oAudio = document.createElement('audio'),
      // 创建a标签
      oHref = document.createElement('a'),
      // 创建播放语音显示按钮
      oSpanPlay = document.createElement('span'),
      // 创建播放语音总时间
      oNumberBox = document.createElement('i'),
      // 创建头像img
      oImg = new Image();
    // 给audio标签添加媒体链接
    oAudio.src = url;
    // 给a标签添加下载链接
    oHref.href = url;
    oHref.download = new Date().toISOString() + '.mp3';
    oHref.innerHTML = oHref.download;
    // 给图片添加路径
    oImg.src = '../images/picture.jpg';
    oSpanPlay.className = 'play-wrap';
    oNumberBox.className = 'num-box';
    setTimeout(function () {
      var nDuration = conversionTime(oAudio.duration);
      // 判断时间是否少于一秒
      if (isNaN(nDuration) || nDuration == 0) {
        oMarkIcon.style.backgroundImage = 'url(../images/mark.png)';
        oTipsTxt.innerText = '说话时间太短';
        // 关闭提示层
        setTimeout(function () {
          oHideTips.style.display = 'none';
          oMarkIcon.style.backgroundImage = 'url(../images/voice.png)';
          oTipsTxt.innerText = '松开发送消息';
        }, 500);
      } else {
        oNumberBox.innerText = nDuration + '″';
        // 将创建好的对象放入li标签
        oLi.appendChild(oAudio);
        oLi.appendChild(oHref);
        oLi.appendChild(oImg);
        oLi.appendChild(oSpanPlay);
        oLi.appendChild(oNumberBox);
        oLi.className = 'clearfix';
        // 将li标签放入语言列表容器
        oWrap.appendChild(oLi);
        // 获取播放语音按钮总的宽度
        var nSpanTotalWidth = parseFloat(getStyle(oLi, 'width')) * 0.7 - oSpanPlay.offsetWidth;
        // 当前播放按钮宽度  当前距离 = 当前时间 / 总时间 * 总距离 + 初始距离
        oSpanPlay.style.width = nDuration / 60 * nSpanTotalWidth + oSpanPlay.offsetWidth - 2 + 'px';
        var bMark = true;
        // 播放语音
        oSpanPlay.onclick = function () {
          if (bMark) {
            this.style.backgroundImage = 'url(../images/voiceplayer1.gif)';
            oAudio.play();
            oAudio.addEventListener('timeupdate', function () {
              if (this.ended) {
                oSpanPlay.style.backgroundImage = 'url(../images/voice2.png)';
              }
            });
          } else {
            this.style.backgroundImage = 'url(../images/voice2.png)';
            oAudio.pause();
          }
          bMark = !bMark;
        }
        // 关闭提示层
        setTimeout(function () {
          oHideTips.style.display = 'none';
        }, 500);
      }
    }, 100);
  });
});
// 转换毫秒时间为秒
function conversionTime(t) {
  var s = Math.floor(t % 60);
  return s;
}
// 获取样式
function getStyle(obj, attr) {
  return window.getComputedStyle(obj, null)[attr]
}
