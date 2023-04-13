{ sources ? import ./nix/sources.nix { } }:
let pkgs = import sources.nixpkgs { };
in pkgs.mkShell rec {
  buildInputs = with pkgs; [
    nixfmt
    temurin-bin-11
  ];
}
