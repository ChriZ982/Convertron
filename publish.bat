set list=basicmodules core server servergui

mkdir release

(for %%a in (%list%) do (
    mkdir release\%%a
    copy %%a\dist\%%a.jar release\%%a\%%a.jar
    mkdir release\%%a\lib
    copy %%a\dist\lib release\%%a\lib
))

PAUSE
