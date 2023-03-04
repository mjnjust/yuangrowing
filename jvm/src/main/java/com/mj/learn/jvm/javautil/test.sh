if ! command -v unzip &> /dev/null;
then if ! command -v apk &> /dev/null;
then if [ -e /etc/system-release ];
	then cat /etc/system-release;
	elif [ -e /etc/redhat-release ];
	then cat /etc/redhat-release;else echo no_system_release;
fi else echo apk_exist;
fi else echo unzip_exist;
fi