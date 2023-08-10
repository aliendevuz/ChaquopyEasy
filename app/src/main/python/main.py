__print_function_from_kotlin__ = 0


def print(*args, sep=" ", end="\n", file=None, flush=None):
    __print_function_from_kotlin__(sep.join(map(str, args)) + end)


def run_code(print_from_kotlin, script):
    global __print_function_from_kotlin__
    __print_function_from_kotlin__ = print_from_kotlin
    def exit():
        def print(*args, sep=" ", end="\n", file=None, flush=None):
            pass
    script = "__name__ = \"__main__\"\n" + script

    try:
        exec(script)
    except Exception as e:
        print(e)
