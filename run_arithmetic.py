import subprocess
import sys
import os

def compile_java():
    print("[*] Compiling Java project...")
    result = subprocess.run(["javac", 
        "arbitraryarithmetic/AInteger.java",
        "arbitraryarithmetic/AFloat.java",
        "arbitraryarithmetic/MyInfArith.java"
    ])
    if result.returncode != 0:
        print("[!] Compilation failed.")
        sys.exit(1)
    print("[+] Compilation successful.")

def run_java(arguments):
    print(f"[*] Running: {' '.join(arguments)}")
    result = subprocess.run(["java", "arbitraryarithmetic.MyInfArith"] + arguments, capture_output=True, text=True)
    if result.returncode != 0:
        print("[!] Error during execution:")
        print(result.stderr)
    else:
        print("[+] Output:")
        print(result.stdout.strip())

def main():
    if len(sys.argv) != 5:
        print("Usage: python run_arithmetic.py <int|float> <add|sub|mul|div> <operand1> <operand2>")
        sys.exit(1)

    compile_java()
    run_java(sys.argv[1:])

if __name__ == "__main__":
    main()
