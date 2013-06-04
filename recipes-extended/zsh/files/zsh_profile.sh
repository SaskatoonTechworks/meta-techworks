if [ "$ZSH_VERSION" ]; then
	emulate -R zsh
	[ "$PS1" ] && PS1='%n@%m:%~%# '
fi
