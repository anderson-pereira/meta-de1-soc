# OpenEmbedded/Yocto BSP layer for Altera DE1-SoC
- BSP layer based on:
	- [meta-altera](https://github.com/kraj/meta-altera)
	- [meta-intelfpga](https://github.com/robseb/meta-intelfpga.git)

## Environment proposal

- **Creating directory tree**
	```Bash
	mkdir -p ~/Projects/Yocto/shared/downloads
	mkdir -p ~/Projects/Yocto/shared/sstate-cache
	mkdir -p ~/Projects/Yocto/Builds/DE1SoC

	cd ~/Projects/Yocto/Builds/DE1SoC && \
		git clone --branch kirkstone git://git.yoctoproject.org/poky.git

	cd ~/Projects/Yocto/Builds/DE1SoC/poky && \
		git clone https://github.com/anderson-pereira/meta-de1-soc.git
	```

- **Directories Overview**
	```Bash
	tree ~/Projects/Yocto/
	├── shared
	│	├── downloads
	│   └── sstate-cache
	└── Builds
		└── DE1SoC
			├── build
			└── poky
				├── meta-de1-soc
				├── meta-poky
				└── ...
	```
- **Starting build enviroment**
	```Bash
	docker run -it --rm \
		--volume ~/Projects/Yocto/shared/downloads:/yocto/downloads \
		--volume ~/Projects/Yocto/shared/sstate-cache:/yocto/sstate-cache \
		--volume ~/Projects/Yocto/Builds/DE1SoC:/yocto/DE1SoC \
		--name=yocto-build-container \
		--workdir=/yocto/DE1SoC \
		--user=$UID \
		andersonazevedo/yocto-build-env \
		bash
	```

- **Configurations and first build**
	- Inside docker container, start with Yocto build environment:
		```Bash
		cd /yocto/DE1SoC
		source poky/oe-init-build-env build
		```
	- Add some base configurations in config/local.conf:
		```Bash
		MACHINE = "de1-soc"
		IMAGE_INSTALL:append = " readbridgesfpga writebridgefpga writeconfigfpga "
		DL_DIR = "/yocto/downloads"
		SSTATE_DIR = "/yocto/sstate-cache"
		```
	- Add meta-de1-soc layer in config/bblayers.conf:
		```Bash
		BBLAYERS ?= " \
		/yocto/DE1SoC/poky/meta \
		/yocto/DE1SoC/poky/meta-poky \
		/yocto/DE1SoC/poky/meta-yocto-bsp \
		/yocto/DE1SoC/poky/meta-de1-soc \
		"
		```
	- Run the first build (and go grab a coffee):
		```Bash
		bitbake core-image-full-cmdline
		```


